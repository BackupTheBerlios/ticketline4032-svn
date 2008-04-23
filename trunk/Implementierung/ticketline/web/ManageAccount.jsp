<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{ManageAccount.page1}" id="page1">
            <webuijsf:html binding="#{ManageAccount.html1}" id="html1">
                <webuijsf:head binding="#{ManageAccount.head1}" id="head1">
                    <webuijsf:link binding="#{ManageAccount.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{ManageAccount.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{ManageAccount.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:label binding="#{ManageAccount.label1}" id="label1"
                                style="height: 20px; left: 72px; top: 96px; position: absolute; width: 59px" text="Vorname"/>
                            <webuijsf:label binding="#{ManageAccount.label2}" id="label2"
                                style="height: 30px; left: 72px; top: 120px; position: absolute; width: 59px" text="Nachname"/>
                            <webuijsf:label binding="#{ManageAccount.label3}" id="label3"
                                style="height: 21px; left: 72px; top: 72px; position: absolute; width: 59px" text="Titel"/>
                            <webuijsf:label binding="#{ManageAccount.label4}" id="label4"
                                style="height: 21px; left: 72px; top: 168px; position: absolute; width: 69px" text="Geschlecht"/>
                            <webuijsf:label binding="#{ManageAccount.label5}" id="label5"
                                style="height: 21px; left: 72px; top: 144px; position: absolute; width: 93px" text="Geburtsdatum"/>
                            <webuijsf:label binding="#{ManageAccount.label6}" id="label6"
                                style="height: 21px; left: 72px; top: 192px; position: absolute; width: 59px" text="Straße"/>
                            <webuijsf:label binding="#{ManageAccount.label7}" id="label7"
                                style="height: 20px; left: 72px; top: 216px; position: absolute; width: 93px" text="Hausnummer"/>
                            <webuijsf:label binding="#{ManageAccount.label8}" id="label8"
                                style="height: 20px; left: 72px; top: 240px; position: absolute; width: 59px" text="Ort"/>
                            <webuijsf:label binding="#{ManageAccount.label9}" id="label9"
                                style="height: 20px; left: 72px; top: 264px; position: absolute; width: 45px" text="PLZ"/>
                            <webuijsf:label binding="#{ManageAccount.label10}" id="label10"
                                style="height: 20px; left: 72px; top: 288px; position: absolute; width: 59px" text="Telefon"/>
                            <webuijsf:label binding="#{ManageAccount.label11}" id="label11"
                                style="height: 20px; left: 72px; top: 312px; position: absolute; width: 59px" text="E-Mail"/>
                            <webuijsf:label binding="#{ManageAccount.label12}" id="label12"
                                style="height: 20px; left: 72px; top: 336px; position: absolute; width: 93px" text="Kontonummer"/>
                            <webuijsf:label binding="#{ManageAccount.label13}" id="label13"
                                style="height: 20px; left: 72px; top: 360px; position: absolute; width: 59px" text="BLZ"/>
                            <webuijsf:label binding="#{ManageAccount.label14}" id="label14"
                                style="height: 20px; left: 72px; top: 384px; position: absolute; width: 93px" text="Kreditkartennnr."/>
                            <webuijsf:label binding="#{ManageAccount.label15}" id="label15"
                                style="height: 20px; left: 72px; top: 408px; position: absolute; width: 117px" text="Kreditkarte gültig bis"/>
                            <webuijsf:label binding="#{ManageAccount.label16}" id="label16"
                                style="height: 20px; left: 72px; top: 432px; position: absolute; width: 117px" text="neues Passwort"/>
                            <webuijsf:textField binding="#{ManageAccount.textField1}" id="textField1"
                                style="height: 20px; left: 216px; top: 96px; position: absolute; width: 117px" text="Vorname" valueChangeListenerExpression="#{ManageAccount.textField1_processValueChange}"/>
                            <webuijsf:textField binding="#{ManageAccount.textField2}" id="textField2"
                                style="height: 20px; left: 216px; top: 120px; position: absolute; width: 117px" text="Nachname"/>
                            <webuijsf:textField binding="#{ManageAccount.textField3}" id="textField3"
                                style="height: 20px; left: 216px; top: 72px; position: absolute; width: 117px" text="titel" valueChangeListenerExpression="#{ManageAccount.textField3_processValueChange}"/>
                            <webuijsf:textField binding="#{ManageAccount.textField4}" id="textField4"
                                style="height: 20px; left: 216px; top: 144px; position: absolute; width: 117px" text="Geburtsdatum"/>
                            <webuijsf:textField binding="#{ManageAccount.textField5}" id="textField5" style="height: 20px; left: 216px; top: 192px; position: absolute; width: 117px"/>
                            <webuijsf:textField binding="#{ManageAccount.textField6}" id="textField6"
                                style="height: 20px; left: 216px; top: 192px; position: absolute; width: 117px" text="Straße"/>
                            <webuijsf:textField binding="#{ManageAccount.textField7}" id="textField7"
                                style="height: 20px; left: 216px; top: 216px; position: absolute; width: 117px" text="Hausnummer"/>
                            <webuijsf:textField binding="#{ManageAccount.textField8}" id="textField8"
                                style="height: 20px; left: 216px; top: 240px; position: absolute; width: 117px" text="Ort"/>
                            <webuijsf:textField binding="#{ManageAccount.textField9}" id="textField9"
                                style="height: 20px; left: 216px; top: 264px; position: absolute; width: 117px" text="PLZ"/>
                            <webuijsf:textField binding="#{ManageAccount.textField10}" id="textField10"
                                style="height: 20px; left: 216px; top: 288px; position: absolute; width: 117px" text="Telefon"/>
                            <webuijsf:textField binding="#{ManageAccount.textField11}" id="textField11" style="height: 20px; left: 216px; top: 336px; position: absolute; width: 117px"/>
                            <webuijsf:textField binding="#{ManageAccount.textField12}" id="textField12"
                                style="height: 20px; left: 216px; top: 312px; position: absolute; width: 117px" text="email" valueChangeListenerExpression="#{ManageAccount.textField12_processValueChange}"/>
                            <webuijsf:textField binding="#{ManageAccount.textField13}" id="textField13"
                                style="height: 20px; left: 216px; top: 332px; position: absolute; width: 117px" text="kontonummer"/>
                            <webuijsf:textField binding="#{ManageAccount.textField14}" id="textField14"
                                style="height: 20px; left: 216px; top: 352px; position: absolute; width: 117px" text="blz"/>
                            <webuijsf:textField binding="#{ManageAccount.textField15}" id="textField15"
                                style="height: 20px; left: 216px; top: 378px; position: absolute; width: 117px" text="kreditnummer"/>
                            <webuijsf:textField binding="#{ManageAccount.textField16}" id="textField16"
                                style="height: 20px; left: 216px; top: 408px; position: absolute; width: 117px" text="gültig"/>
                            <webuijsf:passwordField binding="#{ManageAccount.passwordField1}" id="passwordField1" style="height: 20px; left: 216px; top: 428px; position: absolute; width: 117px"/>
                            <webuijsf:radioButton binding="#{ManageAccount.radioButton2}" id="radioButton2" label="male" name="male" style="height: 20px; left: 216px; top: 168px; position: absolute; width: 69px"/>
                            <webuijsf:radioButton binding="#{ManageAccount.radioButton4}" id="radioButton4" label="female" name="female" style="height: 20px; left: 312px; top: 168px; position: absolute; width: 69px"/>
                            <webuijsf:button binding="#{ManageAccount.button1}" id="button1"
                                style="height: 20px; left: 431px; top: 432px; position: absolute; width: 117px" text="Speichern"/>
                        </div>
                        <webuijsf:staticText binding="#{ManageAccount.staticText4}" id="staticText4"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; height: 46px; left: 264px; top: 144px; position: absolute; width: 214px" text="Account verwalten"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
