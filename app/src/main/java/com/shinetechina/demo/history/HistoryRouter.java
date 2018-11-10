package com.shinetechina.demo.history;

import android.support.annotation.NonNull;
import android.view.View;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link HistoryBuilder.HistoryScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class HistoryRouter extends
    ViewRouter<HistoryView, HistoryInteractor, HistoryBuilder.Component> {

  public HistoryRouter(
      HistoryView view,
      HistoryInteractor interactor,
      HistoryBuilder.Component component) {
    super(view, interactor, component);
  }
}
