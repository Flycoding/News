<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<news> 
	<c:forEach items="${news }" var="item">
		<new id="${item.id }">
			<title>${item.title }></title>
			<viewCount>${item.viewCount }></viewCount>
		</new>
	</c:forEach>
</news>
