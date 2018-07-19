package com.mygdx.game;

/**
 * JsniTest jsniTest = new JsniTest();
 *		jsniTest.alert("Hello MyGdxGame!");
 *		jsniTest.jsCallJava();
 https://github.com/libgdx/libgdx/wiki/Reflection
 * Created by xff on 2018/6/28.
 */

public class JsniTest {

    /**
     * java  调用  js alert方法
     */
    public static native void alert(String str)
	 /*-{
	    $wnd.alertStr(str);
	}-*/;

    public static native void debugLog(String str)
	 /*-{
	    $wnd.gdxLog(str);
	}-*/;

    /**
     * java 调用 js  （在这个方法中会先 调用一次outJsCallGwt 方法 类似于声明该方法[必须]。 在js 的callJavafunction 方法中会调用 outJsCallGwt方法）
     */
    public static native void jsCallJava()/*-{
		@com.mygdx.game.JsniTest::outJsCallGwt(Ljava/lang/String;)("str");
		$wnd.callJavafunction();
	}-*/;

    /**
     * js 中 回调 java 的方法  此方法需要先调用一次
     */
    public static native void outJsCallGwt(String str)/*-{
	 	$wnd.outJsCallGwt = function (str) {
		    @com.mygdx.game.JsniTest::callback(Ljava/lang/String;)(str);
    	};
	}-*/;

    /**
     * java 方法  （调用alert 是方便在网页上看到回调到java端的结果）
     */
    public static void callback(String str) {
        alert("js call me! " + str);
    }
    public static void callback2() {
        alert("hahah");
    }
    public static  native void registerGlobalGwtJsMethods() /*-{
         $wnd.computeLoanInterest =
          $entry(@com.mygdx.game.JsniTest::computeLoanInterest(II));
    }-*/;
//https://stackoverflow.com/questions/16080099/calling-gwt-java-function-from-javascript?rq=1
    public static void computeLoanInterest(int amt,int a) {
        alert("hahah"+(amt+a));
    }
}