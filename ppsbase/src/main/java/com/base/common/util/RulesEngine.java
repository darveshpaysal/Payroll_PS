package com.base.common.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author RAJ
 */
public class RulesEngine {

    private final ScriptEngineManager engineMgr = new ScriptEngineManager();
    private ScriptEngine engine = null;

    public RulesEngine() {
        engine = engineMgr.getEngineByName("JavaScript");
    }

    public void addVariable(String varName, Object varValue) {
        if (!AppUtil.isBlank(varName)) {
            engine.put(varName, varValue);
        }
    }

    public boolean evalRule(String rule) throws Exception {
        boolean outcome = false;
        if (!AppUtil.isBlank(rule)) {
            outcome = (boolean) engine.eval(rule);
        }
        return outcome;
    }
    
    public void clearVariables() {
        engine = engineMgr.getEngineByName("JavaScript");
    }

}
