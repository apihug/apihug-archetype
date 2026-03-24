// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.department.DeptStatusEnum;
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
public class DeptStatusEnumTitleList extends ArrayList<DeptStatusEnum> {
  public static DeptStatusEnumTitleList EMPTY = new DeptStatusEnumTitleList() {
    @Override
    public boolean add(DeptStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public DeptStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, DeptStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends DeptStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends DeptStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<DeptStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super DeptStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public DeptStatusEnumTitleList() {
    super();
  }

  public DeptStatusEnumTitleList(Collection<DeptStatusEnum> given) {
    super(given);
  }

  public List<DeptStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static DeptStatusEnumTitleList from(List<DeptStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new DeptStatusEnumTitleList(given);
    }
  }

  public static DeptStatusEnumTitleList from(DeptStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new DeptStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
