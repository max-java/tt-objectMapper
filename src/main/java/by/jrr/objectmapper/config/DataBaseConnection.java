package by.jrr.objectmapper.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataBaseConnection {
      String databaseUrl;
      String password;
      String user;
}
