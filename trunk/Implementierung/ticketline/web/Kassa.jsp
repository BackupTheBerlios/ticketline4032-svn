<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Kassa.page1}" id="page1">
            <webuijsf:html binding="#{Kassa.html1}" id="html1">
                <webuijsf:head binding="#{Kassa.head1}" id="head1">
                    <webuijsf:link binding="#{Kassa.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Kassa.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Kassa.form1}" id="form1">
                        <div style="height: 478px; left: 20px; top: 130px; position: absolute; width: 915px">
                            <jsp:useBean class="ticketline.Kassa" id="Kassa" scope="session"/>
                            <jsp:getProperty name="Kassa" property="rechnung"/>
                        </div>
                        <webuijsf:panelLayout binding="#{Kassa.panelTop1}" id="panelTop1" style="padding: 10px; background-color: rgb(247, 174, 0); height: 78px; left: 10px; top: 10px; position: absolute; width: 915px; -rave-layout: grid">
                            <webuijsf:image binding="#{Kassa.imageLogo1}" height="80" id="imageLogo1" style="left: 10px; top: 10px; position: absolute"
                                url="resources/logo.png" width="80"/>
                            <webuijsf:staticText binding="#{Kassa.staticTextTitle1}" id="staticTextTitle1"
                                style="font-size: 40px; left: 290px; top: 20px; position: absolute" text="TicketLine Rechnung"/>
                            <webuijsf:hyperlink binding="#{Kassa.hyperlink1}" id="hyperlink1" style="left: 890px; top: 80px; position: absolute" text="Zurück" url="MainPage.jsp"/>
                        </webuijsf:panelLayout>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
