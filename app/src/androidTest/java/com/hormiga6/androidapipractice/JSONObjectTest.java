package com.hormiga6.androidapipractice;

import androidx.test.filters.SmallTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class JSONObjectTest {

    @Test
    public void getWithExistingKey() throws JSONException {
        JSONObject jsonObject = new JSONObject("{key_outer:{key_inner:\"val\"}}");
        assertThat(jsonObject.getString("key_outer"), is("{\"key_inner\":\"val\"}"));
    }

    @Test(expected = JSONException.class)
    public void getObjectAndArray() throws JSONException {
        JSONObject obj = new JSONObject("{key_outer:[1,2,3]}");
        assertThat(obj.getJSONObject("key_outer"),is(any(JSONObject.class)));
    }

    @Test
    public void compare() throws JSONException {
        JSONObject obj = new JSONObject("{key_outer:{key_inner:\"val\"}}");
        //JSONObject compare reference itself. Not value
        assertThat(obj.equals(new JSONObject("{key_outer:{key_inner:\"val\"}}")), is(false));
    }

    @Test(expected = JSONException.class)
    public void getWithNotExistigKey() throws JSONException {
        JSONObject jsonObject = new JSONObject("{key_outer:{key_inner:\"val\"}}");
        jsonObject.getString("hoge");
    }

    @Test
    public void mapToJson(){
        Map<String, ?> map = new HashMap<String, Object>(){{
            put("key1",false);
            put("key2","false");
        }};
        JSONObject json = new JSONObject(map);
        assertThat(json.toString(), is("{\"key1\":false,\"key2\":\"false\"}"));
    }

    @Test
    public void nullValue() throws JSONException {
        JSONObject json = new JSONObject("{\"key1\":null}");
        assertThat(json.isNull("key1"),is(true));
        assertThat(json.getString("key1"), is("null"));
    }
}
