package junit.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import youkidkk.util.test.rule.LoggingRule;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ExpectedException サンプル
 */
public class ExpectedExceptionSample {

    /** ロガー */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /** ルール : 予期された例外 */
    public ExpectedException thrown = ExpectedException.none();

    /** ルールチェーン */
    @Rule
    public RuleChain ruleChain = RuleChain
            .outerRule(new LoggingRule(this.logger))
            .around(this.thrown);

    /**
     * ExpectedException#expect のサンプル
     *
     * @throws Exception 例外
     */
    @Test
    public void expect() throws Exception {
        this.thrown.expect(IOException.class);
        this.thrown.expectMessage("Exception Test");

        // 例外クラス、メッセージが一致するためOK
        throw new IOException("Exception Test");
    }

    /**
     * ExpectedException#expect のサンプル（サブクラスの場合）
     *
     * @throws Exception 例外
     */
    @Test
    public void expectSuperClass() throws Exception {
        this.thrown.expect(IOException.class);

        // FileNotFoundException は IOException のサブクラスのためOK
        throw new FileNotFoundException();

        // Exception は IOException のサブクラスではないためNG
        // throw new Exception();
    }

}
