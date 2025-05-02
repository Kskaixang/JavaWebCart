<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購物車</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
    <style>
        #preview {
            margin-top: 10px;
            max-width: 200px;
            max-height: 200px;
            border: 1px solid #ddd;
            padding: 5px;
        }
    </style>
</head>
<body>
    <%@ include file="/WEB-INF/view/cart/menu.jsp" %>

    <div style="padding: 15px" class="pure-form">
        <table>
            <td valign="top">
                <fieldset>
                    <legend>購物車</legend>
                    <table class="pure-table pure-table-bordered">
                        <thead>
                            <tr>
                                <th>訂單</th><th>時間</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="0" />
                            <c:forEach var="oeder" items="${HistoryOederDTOs}" varStatus="status">
                                
                                <tr onmouseover="this.style.backgroundColor='#E0E0ff'" 
                                    onmouseout="this.style.backgroundColor=''">
                                   
                                    <td align="center">${oeder.product}</td>
                                    
                                    <td align="center">
									    <fmt:formatDate value="${oeder.otime}" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
                                </tr>
                            </c:forEach>
                            <!-- 總計 -->
                            
                        </tbody>
                    </table>
                </fieldset>
            </td>
        </table>
    </div>
</body>
</html>