package com.company.Infrastructure.config;

public class ConfigurationManager {

    private static final String TEST_BROWSER = "Chrome";
    private static final String TEST_ENV = "test env";
    private static final String RUN_ON = "run on";
    private static final String MOBILE_OS = "mobile os";

    private static com.company.Infrastructure.config.ConfigurationManager instance;
    //pricate static final String MOBILE

    private ConfigurationManager(){}

    public static com.company.Infrastructure.config.ConfigurationManager getInstance()
    {
        if (instance == null)
            instance = new com.company.Infrastructure.config.ConfigurationManager();

        return instance;
    }

    private String getEnvVarOrDefaultValue (String envVar, String defaultValue){
        if (System.getenv(envVar) == null || System.getenv(envVar).isEmpty())
            return defaultValue;

        return System.getenv(envVar);
    }

    public String getBrowser(){
        return getEnvVarOrDefaultValue(TEST_BROWSER,"Chrome");
    }

    public String getTestEnv(){
        return getEnvVarOrDefaultValue(TEST_ENV, "Production");
    }

    public String getRunOn() {return getEnvVarOrDefaultValue(RUN_ON, "local");}

    public Object getMobileOs() { return MOBILE_OS;}

    public String getWebDriver(){
        return getEnvVarOrDefaultValue("testWebDriver", "local");
    }
}

