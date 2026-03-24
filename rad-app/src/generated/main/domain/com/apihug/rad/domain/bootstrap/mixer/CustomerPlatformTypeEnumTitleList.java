// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.customer.CustomerPlatformTypeEnum;
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
public class CustomerPlatformTypeEnumTitleList extends ArrayList<CustomerPlatformTypeEnum> {
  public static CustomerPlatformTypeEnumTitleList EMPTY = new CustomerPlatformTypeEnumTitleList() {
    @Override
    public boolean add(CustomerPlatformTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public CustomerPlatformTypeEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, CustomerPlatformTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends CustomerPlatformTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends CustomerPlatformTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<CustomerPlatformTypeEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super CustomerPlatformTypeEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public CustomerPlatformTypeEnumTitleList() {
    super();
  }

  public CustomerPlatformTypeEnumTitleList(Collection<CustomerPlatformTypeEnum> given) {
    super(given);
  }

  public List<CustomerPlatformTypeEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static CustomerPlatformTypeEnumTitleList from(List<CustomerPlatformTypeEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new CustomerPlatformTypeEnumTitleList(given);
    }
  }

  public static CustomerPlatformTypeEnumTitleList from(CustomerPlatformTypeEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new CustomerPlatformTypeEnumTitleList(Arrays.asList(given));
    }
  }
}
