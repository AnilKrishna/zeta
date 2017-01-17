package zeta.android.myntra.utils;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.ParametersAreNonnullByDefault;

import okio.BufferedSource;
import okio.Okio;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class TestUtils {

    private static final String DATE_FORMAT = "MM/dd/yyyy";

    public static String getFormattedDate(@Nullable Date date) {
        if (date == null) {
            return StringUtils.EMPTY_STRING;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        return sdf.format(date);
    }

    public static <T> T deserialize(String fileName, Class<T> clazz) {
        String jsonString = getResponseString(fileName);
        return new Gson().fromJson(jsonString, clazz);
    }

    public static <T> List<T> deserializeList(String fileName, Class<T[]> clazz) {
        String jsonString = getResponseString(fileName);
        T[] arr = new Gson().fromJson(jsonString, clazz);
        return Arrays.asList(arr);
    }

    private static String getResponseString(String fileName) {
        try {
            InputStream stream = TestUtils.class.getClassLoader().getResourceAsStream(fileName);
            if (stream != null) {
                BufferedSource source = Okio.buffer(Okio.source(stream));
                return source.readUtf8();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY_STRING;
    }

}
