package jaxb.sample;

import jaxb.sample.data.Hoge;
import jaxb.sample.data.Piyo;

import javax.xml.bind.JAXB;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * JAXB サンプル
 */
@SuppressWarnings("javadoc")
public class JaxbSample {

    /**
     * Object → XML 変換
     */
    public static void objectToXml() {
        System.out.println("★☆★ Object -> XML ★☆★");

        List<Piyo> piyos = Arrays.asList(new Piyo(1, "text 1"), new Piyo(2, "text 2"),
                new Piyo(2, "text 3"));

        Hoge hoge = new Hoge(123, "text 321", piyos);

        JAXB.marshal(hoge, System.out);

        System.out.println();
    }

    /**
     * XML → Object 変換
     */
    public static void xmlToObject() {
        System.out.println("★☆★ XML -> Object ★☆★");

        File target = new File(ClassLoader.getSystemResource("hoge.xml").getFile());

        Hoge hoge = JAXB.unmarshal(target, Hoge.class);
        System.out.println(hoge);

        System.out.println();
    }

    public static void main(String[] args) {
        objectToXml();
        xmlToObject();
    }

}
