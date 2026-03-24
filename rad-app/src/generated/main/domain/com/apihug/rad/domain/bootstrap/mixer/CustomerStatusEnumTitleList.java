// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.customer.CustomerStatusEnum;
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
public class CustomerStatusEnumTitleList extends ArrayList<CustomerStatusEnum> {
  public static CustomerStatusEnumTitleList EMPTY = new CustomerStatusEnumTitleList() {
    @Override
    public boolean add(CustomerStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public CustomerStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, CustomerStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends CustomerStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends CustomerStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<CustomerStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super CustomerStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public CustomerStatusEnumTitleList() {
    super();
  }

  public CustomerStatusEnumTitleList(Collection<CustomerStatusEnum> given) {
    super(given);
  }

  public List<CustomerStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static CustomerStatusEnumTitleList from(List<CustomerStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new CustomerStatusEnumTitleList(given);
    }
  }

  public static CustomerStatusEnumTitleList from(CustomerStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new CustomerStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
