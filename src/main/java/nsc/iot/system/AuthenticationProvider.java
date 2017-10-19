package nsc.iot.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
    @Autowired
    private HttpSession session;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName().trim();
        String passWord = authentication.getCredentials().toString().trim();

        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication auth = new UsernamePasswordAuthenticationToken(userName, passWord, grantedAuths);
        return auth;

//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("user_name", userName);
//        params.add("pass_word", passWord);
//        String res = APIReader.readString(String.format("%s/member/authen", getAPIURL()), params);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
////            JsonNode root = mapper.readTree(res);
////            List<MemberMapping> memberList = mapper.readValue(root.at("/data").toString(), new TypeReference<List<MemberMapping>>() {
////            });
//            if (memberList != null && !memberList.isEmpty()) {
//                if (memberList.size() == 1) {
////                    session.setAttribute("api_sec", memberList.iterator().next());
////                    MemberMapping member = memberList.iterator().next();
//
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}