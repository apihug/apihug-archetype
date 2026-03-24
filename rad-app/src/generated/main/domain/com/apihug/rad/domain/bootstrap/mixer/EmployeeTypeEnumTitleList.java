// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.organization.EmployeeTypeEnum;
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
public class EmployeeTypeEnumTitleList extends ArrayList<EmployeeTypeEnum> {
  public static EmployeeTypeEnumTitleList EMPTY = new EmployeeTypeEnumTitleList() {
    @Override
    public boolean add(EmployeeTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public EmployeeTypeEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, EmployeeTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends EmployeeTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends EmployeeTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<EmployeeTypeEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super EmployeeTypeEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public EmployeeTypeEnumTitleList() {
    super();
  }

  public EmployeeTypeEnumTitleList(Collection<EmployeeTypeEnum> given) {
    super(given);
  }

  public List<EmployeeTypeEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static EmployeeTypeEnumTitleList from(List<EmployeeTypeEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new EmployeeTypeEnumTitleList(given);
    }
  }

  public static EmployeeTypeEnumTitleList from(EmployeeTypeEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new EmployeeTypeEnumTitleList(Arrays.asList(given));
    }
  }
}
