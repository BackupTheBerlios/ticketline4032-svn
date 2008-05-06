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
                            title="News" width="743">
                            <webuijsf:tableRowGroup binding="#{MainPage.tableRowGroup1}" id="tableRowGroup1" rows="10" sourceData="#{SessionBean1.news}" sourceVar="currentRow">
                                <webuijsf:tableColumn binding="#{MainPage.tableColumn1}" headerText="Datum" id="tableColumn1" sort="gueltig" width="185">
                                    <webuijsf:staticText binding="#{MainPage.staticText1}" id="staticText1" text="#{currentRow.value.gueltig}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{MainPage.tableColumn2}" headerText="Eintrag" id="tableColumn2" sort="titel" width="408">
                                    <webuijsf:staticText binding="#{MainPage.staticText2}" id="staticText2" text="#{currentRow.value.titel}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{MainPage.tableColumn3}" headerText="Auswahl" id="tableColumn3">
                                    <webuijsf:radioButton binding="#{MainPage.radioButton1}" id="radioButton1" label="Details"
                                        name="radioButton-group-tableColumn3" />
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:staticText binding="#{MainPage.textNewsDetails}" id="textNewsDetails" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; height: 118px; left: 192px; top: 288px; position: absolute; width: 741px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
