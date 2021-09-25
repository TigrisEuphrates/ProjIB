package autotest.core.data;

import autotest.core.base.BaseTest;
import autotest.core.helper.Randomizer;
import org.testng.annotations.DataProvider;

/*
* DataProviderClass предоставляет тестовые данные для методов с аннотацией @Test,
* DataProviderClass это возможность фреймворка testng
* в данном примере передается только одно значение, пример приведен для наглядности,
* для эффективности используйте данный класс когда передаете несколько данных,
* название метода в идеале должна намекать на определение тестовых данных
* */
public class DataProviderClass extends BaseTest {
    @DataProvider
    public Object[][] searchData(){
        return new Object[][]{
                {}
        };
    }
}
