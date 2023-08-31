package com.journaldev.design.test;

import java.sql.Connection;
import com.journaldev.design.facade.Helperfacade;
import com.journaldev.design.facade.MySqlHelper;
import com.journaldev.design.facade.OracleHelper;

public class FacadePatternTest {
    public static void main(String[] args) {
        String tableName = "Employee";
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOraleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

        Helperfacade.generateReport(Helperfacade.DBTypes.MYSQL, Helperfacade.ReportTypes.HTML, tableName);
        Helperfacade.generateReport(Helperfacade.DBTypes.ORACLE, Helperfacade.ReportTypes.PDF, tableName);
    }
}