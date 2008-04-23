<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchResultVeranstaltungen
    Created on : 23.04.2008, 17:12:14
    Author     : Chris
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{PlatzAuswahl.page1}" id="page1">
            <webuijsf:html binding="#{PlatzAuswahl.html1}" id="html1">
                <webuijsf:head binding="#{PlatzAuswahl.head1}" id="head1">
                    <webuijsf:link binding="#{PlatzAuswahl.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{PlatzAuswahl.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{PlatzAuswahl.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 694px; left: 192px; top: 144px; position: absolute; width: 742px">
                            <webuijsf:staticText binding="#{PlatzAuswahl.staticTextVeranstaltungen1}" id="staticTextVeranstaltungen1"
                                style="font-size: 30px; left: 240px; top: 0px; position: absolute" text="verfügbare Plätze"/>
                            <h:dataTable binding="#{PlatzAuswahl.dataTable1}" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd "
                                style="left: 24px; top: 72px; position: absolute" value="#{PlatzAuswahl.dataTable1Model}" var="currentRow" width="695">
                                <h:column binding="#{PlatzAuswahl.column1}" id="column1">
                                    <h:outputText binding="#{PlatzAuswahl.outputText1}" id="outputText1" value="#{currentRow['COLUMN1']}"/>
                                </h:column>
                                <h:column binding="#{PlatzAuswahl.column2}" id="column2">
                                    <h:outputText binding="#{PlatzAuswahl.outputText3}" id="outputText3" value="#{currentRow['COLUMN2']}"/>
                                </h:column>
                                <h:column binding="#{PlatzAuswahl.column3}" id="column3">
                                    <h:outputText binding="#{PlatzAuswahl.outputText5}" id="outputText5" value="#{currentRow['COLUMN3']}"/>
                                </h:column>
                            </h:dataTable>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
