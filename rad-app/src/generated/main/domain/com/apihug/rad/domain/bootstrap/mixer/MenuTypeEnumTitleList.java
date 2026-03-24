// @formatter:off
package com.apihug.rad.domain.bootstrap.mixer;

import com.apihug.rad.infra.menu.MenuTypeEnum;
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
public class MenuTypeEnumTitleList extends ArrayList<MenuTypeEnum> {
  public static MenuTypeEnumTitleList EMPTY = new MenuTypeEnumTitleList() {
    @Override
    public boolean add(MenuTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public MenuTypeEnum remove(int index) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, MenuTypeEnum item) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends MenuTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends MenuTypeEnum> items) {
      throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<MenuTypeEnum> operator) {
      throw new UnsupportedOperationException();
    }

    public void sort(Comparator<? super MenuTypeEnum> comparator) {
      throw new UnsupportedOperationException();
    }
  };

  public MenuTypeEnumTitleList() {
    super();
  }

  public MenuTypeEnumTitleList(Collection<MenuTypeEnum> given) {
    super(given);
  }

  public List<MenuTypeEnum> asList() {
    if (this.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(this);
  }

  public static MenuTypeEnumTitleList from(List<MenuTypeEnum> given) {
    if (given == null || given.isEmpty()) {
      return EMPTY;
    }
    else {
      return new MenuTypeEnumTitleList(given);
    }
  }

  public static MenuTypeEnumTitleList from(MenuTypeEnum... given) {
    if (given == null || given.length == 0) {
      return EMPTY;
    }
    else {
      return new MenuTypeEnumTitleList(Arrays.asList(given));
    }
  }
}
