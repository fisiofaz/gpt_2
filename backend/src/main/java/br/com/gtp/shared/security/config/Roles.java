package br.com.gtp.shared.security.config;

import br.com.gtp.shared.enums.Role;

public final class Roles {

    private Roles() {
    }

    public static final String ADMIN = Role.ADMIN.name();
    public static final String SERVICE_OVERSEER = Role.SERVICE_OVERSEER.name();
    public static final String ELDER = Role.ELDER.name();
    public static final String MINISTERIAL_SERVANT = Role.MINISTERIAL_SERVANT.name();
    public static final String PUBLISHER = Role.PUBLISHER.name();
}