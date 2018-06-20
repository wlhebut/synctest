package com.huntech.web.common;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by JHT0701 on 2015/10/4.
 * 计算公式工具类
 */
public class FormulaUtils {
    private static final double THEORY_PARAM=3.6;
    private static final double THEORY_CAL_PARAM=1.0;
    private static final double SALE_CAL_PARAM=1.0;
    /**
     *
     */
    private static final double EMIS_CO2_PARAM =0.997d;//0.36; //0.785d; //(发电量/1000)*0.36
    private static final double SAVE_COAL_PARAM =0.4d;//0.36*0.97; //0.123d; //(发电量/1000)*0.36*0.997
    /**
     * 计算理论电量
     * @param radiation 辐射量MJ/m2
     * @param cap 装机容量MW
     * @return 度
     */
    public static Double calTheoryEnergy(Double radiation,Double cap){
        if(radiation==null || cap==null){
            return null;
        }
        double res=0.0;
        if(radiation!=0&&cap!=0 && radiation!=null && cap!=null){
            res=(radiation/THEORY_PARAM)*cap*1000.0;
        }
        return setScale(res,2);
    }

    /**
     * 计算等效利用小时数
     * @param  oe 上网电量kW.h
     * @param cap 装机容量MW
     * @return
     */
    public static double calEqualHours(Double oe,Double cap){
        double res=0.0;
        if(oe!=null && cap!=null && oe!=0&&cap!=0){
            res=oe/cap/1000.0;
        }
        return setScale(res,2);
    }
    /**
     * 计算厂用电量
     * @param e 发电量kW.h
     * @param supplyE 供电量kW.h
     * @return 度
     */
    public static double calFactoryEnergy(double e,double supplyE){
        double res=0.0;
        res=(e-supplyE);
        return setScale(res,2);
    }

    /**
     * 计算系统效率
     * @param radiation 辐射量MJ/m2
     * @param cap 装机容量MW
     * @param onrgidE 上网电量kW.h
     * @return
     */
    public static Double calSystemEfficiency(Double radiation,Double cap,Double onrgidE){
        double res=0.0;
        if(radiation==null || cap==null || onrgidE==null){
            return null;
        }
        if(radiation!=0&&cap!=0&&onrgidE!=0){
            res=onrgidE/((radiation/THEORY_PARAM)*cap*1000.0)*100.0;
        }
        return setScale(res,2);
    }
    
    public static Double calSystemEfficiencybiaogan(Double dailyPowerSupply ,Double biaoganenergy){
        double res=0.0;
        if(dailyPowerSupply==null || dailyPowerSupply==null ){
            return null;
        }
        if(dailyPowerSupply!=0&&biaoganenergy!=0){
            res=(dailyPowerSupply/(biaoganenergy))*100.0;
        }
        return setScale(res,2);
    }
    
    public static Double calSystemEfficiency2(Double radiation,Double cap,Double onrgidE){
        Double res=null;
        if(radiation==null || cap==null || onrgidE==null){
            return null;
        }
        if(radiation!=0&&cap!=0&&onrgidE!=0){
            res=0.0;
            res=onrgidE/((radiation/THEORY_PARAM)*cap*1000.0)*100.0;
            return setScale(res,2);
        }
        return res;
    }
    /**
     * 计算系统效率
     * @param ongridE 电量
     * @param theoryE 理论电量
     * @return
     */
    public static Double calSystemEfficiency(Double ongridE,Double theoryE){
        double res=0.0;
        if(ongridE==null || theoryE==null ){
            return null;
        }
        if(ongridE!=0&&theoryE!=0){
            res=ongridE/theoryE*100.0;
        }
        return setScale(res,2);
    }

    /**
     * 计算预算完成率
     * @param planE kW.h
     * @param e kW.h
     * @return
     */
    public static double calPlanCompleteRatio(double e,double planE){
        double res=0.0;
        if(planE!=0&&e!=0){
            res=(e/planE)*100.0;
        }
        return setScale(res,2);
    }
    public static Double calPlanCompleteRatio2(Double e,Double planE){
        Double res=null;
        if(planE!=0&&e!=0&&planE!=null &&e!=null){
            res=0.0;
            res=(e/planE)*100.0;
            return setScale(res,2);
        }
        if(planE==0&&e!=0&&planE!=null &&e!=null){
            res=0.0;
            return res;
        }
        return res;
    }
    /**
     * 计算电度销售额
     * @param e kW.h
     * @param up 单价/元
     * @return 元
     */
    public static double calSale(double e,double up){
        double res=0.0;
        res=e*up*SALE_CAL_PARAM;
        return setScale(res,2);
    }


    /**
     * 计算综合厂用量
     * @param fe kW.h
     * @param ge kW.h
     * @return 度
     */
    public static double calSumFactoryEnergy(Double fe,Double ge){
        Double res=null;
        //double res=0.0;
        if(fe!=null && ge!=null){
            res=(fe+ge);
        }

        return setScale(res,2);
    }

    /**
     * 计算综合厂用电率
     * @param e  kW.h
     * @param sfe  kW.h
     * @return
     */
    public static double calSumFactoryRatio(double sfe,double e){
        double res=0.0;
        if(e!=0&&sfe!=0){
            res=(sfe/e)*100.0;
        }
        return setScale(res,2);
    }
    public static Double calSumFactoryRatio2(double sfe,double e){
        Double res=null;
        if(e!=0&&sfe!=0){
            res=0.0;
            res=(sfe/e)*100.0;
            return setScale(res,2);
        }
        return res;
    }
    /**
     * 计算综合厂用电率
     * @param e  kW.h
     * @param se  kW.h
     * @param ge kW.h
     * @return
     */
    public static double calSumFactoryRatio(Double se,Double ge,Double e){

        double res=0.0;
        if(e!=null && se !=null){
            double sfe=e-se+(ge==null?0:ge);//发电量-供电量+网馈电量
            if(e!=0&&sfe!=0){
                res=(sfe/e)*100.0;
            }
        }

        return setScale(res,2);
    }

    /**
     * CO2减排
     * @param oe kW.h
     * @return t t
     */
    public static double calEmissionCO2(Double oe){
        double res=0.0;
        if(oe!=null){
            res=oe*EMIS_CO2_PARAM/1000;
        }
        return setScale(res,2);
    }

    /**
     * 节约标煤
     * @param oe kW.h
     * @return t 吨
     */
    public static double calSaveCoal(Double oe){
        double res=0.0;
        if(oe!=null){
            res=oe*SAVE_COAL_PARAM/1000;
        }

        return setScale(res,2);
    }

    public static double setScale(Double d,int n){
        double res=0.0;
        if(d!=null){
            BigDecimal b   =   new   BigDecimal(d);
            res   =   b.setScale(n,   BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        return res;
    }
    public static Double doubleMinus(Double d1,Double d2){
        Double res=null;
        if(d1!=null && d2!=null){
            res=setScale(d1-d2,2);
        }
        return res;
    }
    public static Double doubleDivide(Double d1,Double d2){
        Double res=null;
        if(d1!=null && d2!=null && d2 !=0){
            res=d1/d2;
        }
        return res;
    }

    public static Double doublePlus(Double d1,Double d2){
        Double res=null;
        if(d1!=null && d2!=null){
            res=d1+d2;
        }else if(d1==null && d2!=null){
            res=d2;
        }else if(d1!=null && d2==null){
            res=d1;
        }else{

        }
        return res;
    }

    public static <T> double sumListFiled(List<T> list,String sumField){
        double res=0.0;

        return res;
    }
}
