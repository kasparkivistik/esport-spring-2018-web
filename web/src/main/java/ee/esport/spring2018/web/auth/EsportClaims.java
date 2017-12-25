package ee.esport.spring2018.web.auth;

import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Map;

public class EsportClaims extends DefaultClaims {

    public static final String STEAM_ID = "steam_id";
    public static final String TICKET_ID = "ticket_id";

    public EsportClaims() {}

    public EsportClaims(Map<String, Object> map) {
        super(map);
    }

    public EsportClaims setSteamId(String steamId) {
        setValue(STEAM_ID, steamId);
        return this;
    }

    public EsportClaims setTicketId(long ticketId) {
        setValue(TICKET_ID, ticketId);
        return this;
    }


    public String getSteamId() {
        return getString(STEAM_ID);
    }

    public Long getTicketId() {
        return get(TICKET_ID, Long.class);
    }

}
