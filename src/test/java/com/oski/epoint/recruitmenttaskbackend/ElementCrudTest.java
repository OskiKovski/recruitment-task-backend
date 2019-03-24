package com.oski.epoint.recruitmenttaskbackend;

import com.oski.epoint.recruitmenttaskbackend.controller.ElementController;
import com.oski.epoint.recruitmenttaskbackend.model.Element;
import com.oski.epoint.recruitmenttaskbackend.repository.ElementRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementCrudTest {

  @Mock
  ElementRepository elementRepositoryMock;

  private ElementController elementController;

  @Before
  public void init() {
    elementRepositoryMock = mock(ElementRepository.class);
    elementController = new ElementController(elementRepositoryMock);
  }

  @Test
  public void testDataRetrieval() {
    List<Element> resultList = new ArrayList<>();
    resultList.add(new Element("test1"));
    resultList.add(new Element("test2"));
    resultList.add(new Element("test3"));
    when(elementRepositoryMock.findAll()).thenReturn(resultList);
    assertEquals(resultList, elementController.getElements());
  }

  @Test
  public void testDataRetrieval_OneValue() {
    List<Element> resultList = new ArrayList<>();
    resultList.add(new Element("test1"));
    when(elementRepositoryMock.findAll()).thenReturn(resultList);
    assertEquals(resultList, elementController.getElements());
  }
}