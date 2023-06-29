package constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Position {

    P("투수"), C("포수"),
    First_B("1루수"), Second_B("2루수"), Third_B("3루수"),
    SS("유격수"), LF("좌익수"), CF("중견수"), RF("우익수");

    private String name;

    public static Position findByName(String name) {
        for (Position positon : Position.values()) {
            if (!positon.getName().equals(name))
                continue;

            return positon;
        }

        return null;
    }

}
