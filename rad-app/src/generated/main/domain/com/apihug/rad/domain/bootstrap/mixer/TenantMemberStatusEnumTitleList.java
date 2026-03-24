// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
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
public class TenantMemberStatusEnumTitleList extends ArrayList<TenantMemberStatusEnum> {
  public static TenantMemberStatusEnumTitleList EMPTY = new TenantMemberStatusEnumTitleList() {
    @Override
    public boolean add(TenantMemberStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public TenantMemberStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, TenantMemberStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends TenantMemberStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends TenantMemberStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<TenantMemberStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super TenantMemberStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public TenantMemberStatusEnumTitleList() {
    super();
  }

  public TenantMemberStatusEnumTitleList(Collection<TenantMemberStatusEnum> given) {
    super(given);
  }

  public List<TenantMemberStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static TenantMemberStatusEnumTitleList from(List<TenantMemberStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new TenantMemberStatusEnumTitleList(given);
    }
  }

  public static TenantMemberStatusEnumTitleList from(TenantMemberStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new TenantMemberStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
