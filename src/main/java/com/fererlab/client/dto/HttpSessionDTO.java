package com.fererlab.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpSessionDTO extends MapperDTO {

    private String ipAddressClient;
    private String ipAddressServer;
    private String queryStr;
    private String referrer;
    private String cookieStr;
    private String userAgent;
    private String uri;
    private String sessionId;
    private String applicationFullName;
    private String streamName;
    private String ip;
    private Integer id;
    private String uniqueId;

    public String getIpAddressClient() {
        return ipAddressClient;
    }

    public void setIpAddressClient(String ipAddressClient) {
        this.ipAddressClient = ipAddressClient;
    }

    public String getIpAddressServer() {
        return ipAddressServer;
    }

    public void setIpAddressServer(String ipAddressServer) {
        this.ipAddressServer = ipAddressServer;
    }

    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getCookieStr() {
        return cookieStr;
    }

    public void setCookieStr(String cookieStr) {
        this.cookieStr = cookieStr;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getApplicationFullName() {
        return applicationFullName;
    }

    public void setApplicationFullName(String applicationFullName) {
        this.applicationFullName = applicationFullName;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
