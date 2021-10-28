package com.dnd.base.api.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T extends IPage> {

    private long total;
    private List<T> rows;

    public static <T extends IPage> Page<T> ok(T t) {
        return new Page<>(t.getTotal(), t.getRecords());
    }

    public static <T extends IPage> Page<T> fail(T t) {
        return new Page<>(0, null);
    }

    public static <T extends IPage> Page<T> fail() {
        return fail(null);
    }
}
