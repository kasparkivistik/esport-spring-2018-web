package ee.esport.spring2018.web.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Assert;
import org.junit.Test;

public class JwtServiceTest {

    private static final String KEY = "hxG3uoyXWNuo78iQioLqzPeBoiginU59xV9wB50IA7K" +
                                      "LI838xWzV9r76VzdcNzw0ocJqSXlUoJyqNvc5DgmqeQ";

    @Test
    public void whenEncodedAndDecoded_returnsInitialClaims() {
        JwtService jwtService = new JwtService(SignatureAlgorithm.HS512, KEY);
        EsportClaims originalClaims = new EsportClaims().setSteamId("STEAM_ID").setTicketId(123);
        EsportClaims derivedClaims = jwtService.validateAndGetClaims(jwtService.createFromClaims(originalClaims));
        Assert.assertEquals(originalClaims, derivedClaims);
    }

}