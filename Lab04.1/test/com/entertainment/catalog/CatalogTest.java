/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertEquals(7, tvs.size());
    for (Television tv : tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

  @Test
  public void testFindByBrandsWithNoMatches() {
    Map<String, Collection<Television>> tvs = Catalog.findByBrands("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandsWithMatches() {
    ArrayList<String> brands = new ArrayList<>();
    brands.add("Sony");
    brands.add("Zenith");
    Map<String, Collection<Television>> tvs = Catalog.findByBrands(String.valueOf(brands));
    assertNotNull(tvs);
    for(Map.Entry<String, Collection<Television>> tv : tvs.entrySet()) {
      assertTrue(brands.contains(tv.getKey()));
    }
  }

  @Test
  public void testGetInventoryModifiable() {
    Collection<Television> catalogTest = Catalog.getInventory();
    catalogTest.add(new Television());
    assertNotEquals(catalogTest.size(), Catalog.getInventory().size());
  }

  @Test
  public void testGetInventoryReadOnly() {

  }

}