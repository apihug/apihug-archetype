// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.role.RoleStatusEnum;
import java.lang.Override;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import javax.annotation.Generated;

@Generated("H.O.P.E. Infra Team")
public class RoleStatusEnumTitleList extends ArrayList<RoleStatusEnum> {
  public static RoleStatusEnumTitleList EMPTY = new RoleStatusEnumTitleList() {
    @Override
    public boolean add(RoleStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public RoleStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, RoleStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends RoleStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends RoleStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<RoleStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super RoleStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public RoleStatusEnumTitleList() {
    super();
  }

  public RoleStatusEnumTitleList(Collection<RoleStatusEnum> given) {
    super(given);
  }

  public List<RoleStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static RoleStatusEnumTitleList from(List<RoleStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new RoleStatusEnumTitleList(given);
    }
  }

  public static RoleStatusEnumTitleList from(RoleStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new RoleStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
