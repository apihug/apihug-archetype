// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
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
public class PlatformMemberStatusEnumTitleList extends ArrayList<PlatformMemberStatusEnum> {
  public static PlatformMemberStatusEnumTitleList EMPTY = new PlatformMemberStatusEnumTitleList() {
    @Override
    public boolean add(PlatformMemberStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public PlatformMemberStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, PlatformMemberStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends PlatformMemberStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends PlatformMemberStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<PlatformMemberStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super PlatformMemberStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public PlatformMemberStatusEnumTitleList() {
    super();
  }

  public PlatformMemberStatusEnumTitleList(Collection<PlatformMemberStatusEnum> given) {
    super(given);
  }

  public List<PlatformMemberStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static PlatformMemberStatusEnumTitleList from(List<PlatformMemberStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new PlatformMemberStatusEnumTitleList(given);
    }
  }

  public static PlatformMemberStatusEnumTitleList from(PlatformMemberStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new PlatformMemberStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
