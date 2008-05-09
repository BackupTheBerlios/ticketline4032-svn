<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{MainPage.page1}" id="page1">
            <webuijsf:html binding="#{MainPage.html1}" id="html1">
                <webuijsf:head binding="#{MainPage.head1}" id="head1">
                    <webuijsf:link binding="#{MainPage.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{MainPage.body1}" id="body1" style="-rave-layout: grid">
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{MainPage.form2}" id="form2">
                        <webuijsf:table augmentTitle="false" binding="#{MainPage.tableNews}" id="tableNews" style="left: 192px; top: 144px; position: absolute"
                            title="News" width="741">
                            <webuijsf:tableRowGroup binding="#{MainPage.tableRowGroup1}" emptyDataMsg="Keine News." id="tableRowGroup1" rows="5"
                                selected="#{MainPage.selectedState}" sourceData="#{SessionBean1.news}" sourceVar="currentRow">
                                <webuijsf:tableColumn binding="#{MainPage.tableColumn3}" id="tableColumn3"
                                    onClick="setTimeout(function(){document.getElementById('form2:tableNews').initAllRows()}, 0);" selectId="radioButton1" width="10">
                                    <webuijsf:radioButton binding="#{MainPage.radioButton1}" id="radioButton1" name="radioButton1"
                                        selected="#{MainPage.selected}" selectedValue="#{MainPage.selectedValue}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{MainPage.tableColumn1}" headerText="Datum" id="tableColumn1" width="120" sort="gueltig">
                                    <webuijsf:staticText binding="#{MainPage.staticText1}" id="staticText1" text="#{currentRow.value.gueltig}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{MainPage.tableColumn2}" headerText="Eintrag" id="tableColumn2" sort="titel">
                                    <webuijsf:staticText binding="#{MainPage.staticText2}" id="staticText2" text="#{currentRow.value.titel}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:staticText binding="#{MainPage.textNewsDetails}" id="textNewsDetails" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; height: 142px; left: 312px; top: 336px; position: absolute; width: 621px"/>
                        <webuijsf:button actionExpression="#{MainPage.buttonDetails_action}" binding="#{MainPage.buttonDetails}" id="buttonDetails"
                            style="left: 192px; top: 336px; position: absolute; width: 110px" text="Details zur Auswahl"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
