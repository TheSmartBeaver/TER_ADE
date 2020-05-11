import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SousSecteurListComponent } from './sous-secteur-list.component';

describe('SousSecteurListComponent', () => {
  let component: SousSecteurListComponent;
  let fixture: ComponentFixture<SousSecteurListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SousSecteurListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SousSecteurListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
