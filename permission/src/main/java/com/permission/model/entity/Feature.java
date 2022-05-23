package com.permission.model.entity;

import com.permission.model.bo.Method;
import com.permission.model.bo.StatusCommon;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "features")
@Data
@Accessors(chain = true)
public class Feature {

    @Id
    @SequenceGenerator(name = "features_id_seq", sequenceName = "features_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "features_id_seq")
    private Integer id;

    @Column(length = 100)
    private String actionCode;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(length = 100, nullable = false)
    private String path;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Method method;

    @Column(nullable = false)
    private Integer point;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCommon status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(id, feature.id) &&
                Objects.equals(actionCode, feature.actionCode) &&
                Objects.equals(name, feature.name) &&
                Objects.equals(description, feature.description) &&
                Objects.equals(path, feature.path) &&
                method == feature.method &&
                Objects.equals(point, feature.point) &&
                status == feature.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionCode, name, description, path, method, point, status);
    }
}
