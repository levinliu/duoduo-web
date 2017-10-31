package org.duoduochild.magic.duoduo.web.configuration.properties;

import com.mongodb.WriteConcern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by levinliu on 2017/10/18
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */
@Configuration
@ConfigurationProperties("spring.data.mongodb")
public class MongoDbProperties {
    private String host;
    private int port;
    private String database;
    private String login;
    private String password;
    private String adminDb;
    private PoolOptions poolOptions;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminDb() {
        return adminDb;
    }

    public void setAdminDb(String adminDb) {
        this.adminDb = adminDb;
    }

    public PoolOptions getPoolOptions() {
        return poolOptions;
    }

    public void setPoolOptions(PoolOptions poolOptions) {
        this.poolOptions = poolOptions;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public static class PoolOptions {
        private int connectionsPerHost;
        private int connectTimeout;
        private int maxWaitTime;
        private int socketTimeout;
        private int threadsAllowedToBlockForConnectionMultiplier;
        private WriteConcern writeConcern;

        public int getConnectionsPerHost() {
            return connectionsPerHost;
        }

        public void setConnectionsPerHost(int connectionsPerHost) {
            this.connectionsPerHost = connectionsPerHost;
        }

        public long getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public int getMaxWaitTime() {
            return maxWaitTime;
        }

        public void setMaxWaitTime(int maxWaitTime) {
            this.maxWaitTime = maxWaitTime;
        }

        public int getSocketTimeout() {
            return socketTimeout;
        }

        public void setSocketTimeout(int socketTimeout) {
            this.socketTimeout = socketTimeout;
        }

        public int getThreadsAllowedToBlockForConnectionMultiplier() {
            return threadsAllowedToBlockForConnectionMultiplier;
        }

        public void setThreadsAllowedToBlockForConnectionMultiplier(int threadsAllowedToBlockForConnectionMultiplier) {
            this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
        }

        public WriteConcern getWriteConcern() {
            return writeConcern;
        }

        public void setWriteConcern(WriteConcern writeConcern) {
            this.writeConcern = writeConcern;
        }

        @Override
        public String toString() {
            return "PoolOptions{" +
                    "connectionsPerHost=" + connectionsPerHost +
                    ", connectTimeout=" + connectTimeout +
                    ", maxWaitTime=" + maxWaitTime +
                    ", socketTimeout=" + socketTimeout +
                    ", threadsAllowedToBlockForConnectionMultiplier=" + threadsAllowedToBlockForConnectionMultiplier +
                    ", writeConcern=" + writeConcern +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MongoDbProperties{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", database='" + database + '\'' +
                ", login='" + login + '\'' +
                ", adminDb='" + adminDb + '\'' +
                ", poolOptions=" + poolOptions +
                '}';
    }
}
