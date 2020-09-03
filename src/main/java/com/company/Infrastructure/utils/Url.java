package com.company.Infrastructure.utils;

import java.util.HashMap;
import java.util.Map;

public class Url {

   private Boolean isSecure;
   private String domain;
   private String port = "";
   private String path = "/";
   private String parameters;

    public void setSecure(boolean secure) { isSecure = secure;}

    public boolean getSecure (){return isSecure;}

    public void setDomain(String domain) {this.domain = domain;}

    public String getDomain (){return domain;}

    public void setPath(String path) {this.path = path;}

    public String getPath() {return path;}

    public void setPort(String port) {this.port = port;}

    public String getPort () {return port;}

    public void setParameters (String param) {this.parameters = parameters;}

    public String getParameters () {return parameters;}


    public static class Builder {

        private com.company.Infrastructure.utils.Url url;
        private Map<String, String> params = new HashMap<>();

        public Builder() {
            url = new com.company.Infrastructure.utils.Url();
        }

        public Builder withSecure() {
            url.setSecure(true);
            return this;
        }

        public Builder withDomain(String domain) {
            url.setDomain(domain);
            return this;
        }


        public Builder withPath(String path) {
            url.setPath(url.getPath() + path);
            return this;
        }

        public Builder withPort(String port) {
            url.setPort(port);
            return this;
        }

        public Builder withParam(String param) {
            params.put(param, "");
            return this;
        }


        public Builder withParam(String param, String value) {
            params.put(param, value);
            return this;
        }

        public String build() {
            String protocol = url.getSecure() ? "http://" : "http://";
            String port = url.getPort().isEmpty() ? "" : ":" + url.getPort();

            String parameters = "?";

            for (Map.Entry entry: params.entrySet()){
                if (entry.getValue().toString().isEmpty())
                    parameters += entry.getKey().toString()+ "&";
                else
                    parameters += entry + "&";
            }
            url.setParameters(parameters);

            return protocol + url.getDomain() + port + url.getPath()+ url.getParameters();
        }
    }



















}
