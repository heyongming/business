package com.business.test;

import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import com.alibaba.fastjson.JSONObject;


public class FenciTest {
public static void main(String[] args) {
	List<Term> parse=(List<Term>) NlpAnalysis.parse("让战士们过一个欢乐祥和的新春佳节。");
	System.out.println(parse);
}
}
