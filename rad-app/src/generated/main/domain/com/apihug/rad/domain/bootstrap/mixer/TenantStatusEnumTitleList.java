// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.tenant.TenantStatusEnum;
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
public class TenantStatusEnumTitleList extends ArrayList<TenantStatusEnum> {
  public static TenantStatusEnumTitleList EMPTY = new TenantStatusEnumTitleList() {
    @Override
    public boolean add(TenantStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public TenantStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, TenantStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends TenantStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends TenantStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<TenantStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super TenantStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public TenantStatusEnumTitleList() {
    super();
  }

  public TenantStatusEnumTitleList(Collection<TenantStatusEnum> given) {
    super(given);
  }

  public List<TenantStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static TenantStatusEnumTitleList from(List<TenantStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new TenantStatusEnumTitleList(given);
    }
  }

  public static TenantStatusEnumTitleList from(TenantStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new TenantStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
