package com.duizhuang.demoownthings.converter;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @author: yangguoxiong
 * @date: 2021/2/19 17:53
 * @description:
 */
@Slf4j
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (StrUtil.isNotBlank(s)) {
            if (DatePattern.NORM_DATETIME_PATTERN.length() == s.length()) {
                try {
                    return DateUtil.parse(s, DatePattern.NORM_DATETIME_PATTERN);
                } catch (Exception e) {
                    log.error("日期类型转换错误格式[{}]源[{}]", DatePattern.NORM_DATETIME_PATTERN, s);
                    return null;
                }
            } else if (DatePattern.NORM_DATE_PATTERN.length() == s.length()) {
                try {
                    return DateUtil.parse(s, DatePattern.NORM_DATE_PATTERN);
                } catch (Exception e) {
                    log.error("日期类型转换错误格式[{}]源[{}]", DatePattern.NORM_DATE_PATTERN, s);
                    return null;
                }
            }
            // 如果是数值类型, 说明是时间戳转换
            if (NumberUtil.isNumber(s)) {
                try {
                    return DateUtil.date(Long.parseLong(s));
                } catch (Exception e) {
                    log.error("时间戳转日志类型格式异常: {},异常信息为：{}", s, e.getMessage());
                    return null;
                }
            }
        }
        return null;
    }
}
