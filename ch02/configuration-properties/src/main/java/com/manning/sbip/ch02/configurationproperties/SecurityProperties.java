package com.manning.sbip.ch02.configurationproperties;

import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
public class SecurityProperties {

    /**
     * Enable Security. Possible values true/false
     */
    private boolean enabled;

    /**
     * Token Value
     */
    private final String token;

    /**
     * Available roles
     */
    private final List<String> roles;

    private final String mode;

    public SecurityProperties(boolean enabled, String token, List<String> roles, String mode) {
        this.enabled = enabled;
        this.token = token;
        this.roles = roles;
        this.mode = mode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getToken() {
        return token;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getMode() {
        return mode;
    }



    @Override
    public String toString() {
        return "SecurityProperties{" +
                "enabled=" + enabled +
                ", token='" + token + '\'' +
                ", roles=" + roles +
                ", mode=" + mode +
                '}';
    }
}
