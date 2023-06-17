package com.khai.voroshylov.exception;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ConstraintException extends Exception{

    Map<String, List<String>> exceptionMap;

}
