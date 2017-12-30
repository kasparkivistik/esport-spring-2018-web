package ee.esport.spring2018.web.auth;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtParser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

@Service
@ConfigurationProperties("jwt.signature")
@RequiredArgsConstructor
@AllArgsConstructor
public class JwtService {

    public static final String ISSUER = "TTÜ e-Sport";

    @Setter private SignatureAlgorithm algorithm;
    @Setter private String key;

    public String createFromClaims(EsportClaims claims) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        return new DefaultJwtBuilder().setClaims(claims)
                                      .setExpiration(asLegacyDate(now.plusHours(24)))
                                      .setIssuedAt(asLegacyDate(now))
                                      .setIssuer(ISSUER)
                                      .signWith(algorithm, key)
                                      .compact();
    }

    public EsportClaims validateAndGetClaims(String token) {
        Jws<Claims> parsedToked = new EsportJwtParser().setSigningKey(key).parseClaimsJws(token);
        return new EsportClaims(parsedToked.getBody());
    }

    private Date asLegacyDate(LocalDateTime exp) {
        return Date.from(exp.toInstant(ZoneOffset.UTC));
    }

    private class EsportJwtParser extends DefaultJwtParser {

        private final ObjectReader objectReader;

        public EsportJwtParser() {
            objectReader = new ObjectMapper().readerFor(Map.class)
                                             .withFeatures(DeserializationFeature.USE_LONG_FOR_INTS);
        }

        @SuppressWarnings("unchecked")
        protected Map<String, Object> readValue(String val) {
            try {
                return objectReader.readValue(val);
            } catch (IOException e) {
                throw new MalformedJwtException("Unable to read JSON value: " + val, e);
            }
        }

    }

}
