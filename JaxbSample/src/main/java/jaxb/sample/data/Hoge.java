package jaxb.sample.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor // XML -> Object でデフォルトコンストラクタが必要
@AllArgsConstructor
@Data // Getter、Setter が必要
@SuppressWarnings("javadoc")
public class Hoge {

    private int number;

    private String text;

    private List<Piyo> piyos;

}
