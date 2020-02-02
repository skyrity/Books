package com.skyrity.utils;

/**
 * @author ： VULCAN
 * @date ：2020/02/01 12:53
 * @description : ${description}
 * @path : com.skyrity.utils.RetCode
 * @modifiedBy ：
 */
public class RetCode {
    public static final String RET_SUCCESS = "{\"result_code\":0,\"result_msg\":\"操作成功\",\"result_time\":RESULT_TIME," +
            "\"result_data\":RESULT_DATA}";
    public static final String RET_ERROR = "{\"result_code\":-1,\"result_msg\":\"操作失败！\",\"result_time\":RESULT_TIME}";
    public static final String RET_ERROR_BOOKNAME = "{\"result_code\":-2,\"result_msg\":\"书名重复，操作失败！\",\"result_time\":RESULT_TIME}";
    public static final String RET_ERROR_NOTFOUND = "{\"result_code\":-3,\"result_msg\":\"没有找到该图书，操作失败！\",\"result_time\":RESULT_TIME}";
}
