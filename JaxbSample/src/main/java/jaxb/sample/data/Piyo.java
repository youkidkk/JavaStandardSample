package jaxb.sample.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // XML -> Object でデフォルトコンストラクタが必要
@AllArgsConstructor
@Data // Getter、Setter が必要
@SuppressWarnings("javadoc")
public class Piyo {

    private int number;

    private String text;

}
