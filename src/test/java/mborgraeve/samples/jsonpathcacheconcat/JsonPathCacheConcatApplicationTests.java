package mborgraeve.samples.jsonpathcacheconcat;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

class JsonPathCacheConcatApplicationTests {

    @Test
    void jsonPathReadTest() {
        LinkedHashMap<String, Object> jsonPathObject = new LinkedHashMap<>();
        LinkedHashMap<String, Object> intervalMeasure = new LinkedHashMap<>();
        intervalMeasure.put("date", "2020-01-25");
        intervalMeasure.put("time", "01:00:00");
        jsonPathObject.put("intervalMeasure", intervalMeasure);

        LinkedHashMap<String, Object> jsonPathObject2 = new LinkedHashMap<>();
        LinkedHashMap<String, Object> intervalMeasure2 = new LinkedHashMap<>();
        intervalMeasure2.put("date", "2020-01-25");
        intervalMeasure2.put("time", "01:15:00");
        jsonPathObject2.put("intervalMeasure", intervalMeasure2);

        Object result = JsonPath.read(jsonPathObject, "concat($.intervalMeasure.['date', 'time'])", new Predicate[0]);
        Object result2 = JsonPath.read(jsonPathObject2, "concat($.intervalMeasure.['date', 'time'])", new Predicate[0]);
        assertThat(result).isNotEqualTo(result2);
    }

}
