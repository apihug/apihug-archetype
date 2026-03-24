// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.menu.MenuStatusEnum;
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
public class MenuStatusEnumTitleList extends ArrayList<MenuStatusEnum> {
  public static MenuStatusEnumTitleList EMPTY = new MenuStatusEnumTitleList() {
    @Override
    public boolean add(MenuStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public MenuStatusEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, MenuStatusEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends MenuStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends MenuStatusEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<MenuStatusEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super MenuStatusEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public MenuStatusEnumTitleList() {
    super();
  }

  public MenuStatusEnumTitleList(Collection<MenuStatusEnum> given) {
    super(given);
  }

  public List<MenuStatusEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static MenuStatusEnumTitleList from(List<MenuStatusEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new MenuStatusEnumTitleList(given);
    }
  }

  public static MenuStatusEnumTitleList from(MenuStatusEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new MenuStatusEnumTitleList(Arrays.asList(given));
    }
  }
}
