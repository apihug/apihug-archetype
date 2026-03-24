// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.organization.CustomerOrgStatusEnum;
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
public class CustomerOrgStatusEnumTitleList extends ArrayList<CustomerOrgStatusEnum> {
  public static CustomerOrgStatusEnumTitleList EMPTY = new CustomerOrgStatusEnumTitleList() {
    @Override
    public boolean add(CustomerOrgStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public CustomerOrgStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, CustomerOrgStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends CustomerOrgStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends CustomerOrgStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<CustomerOrgStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super CustomerOrgStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public CustomerOrgStatusEnumTitleList() {
    super();
  }

  public CustomerOrgStatusEnumTitleList(Collection<CustomerOrgStatusEnum> given) {
    super(given);
  }

  public List<CustomerOrgStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static CustomerOrgStatusEnumTitleList from(List<CustomerOrgStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new CustomerOrgStatusEnumTitleList(given);
    }
  }

  public static CustomerOrgStatusEnumTitleList from(CustomerOrgStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new CustomerOrgStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
