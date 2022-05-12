import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllsComponent } from './show-alls.component';

describe('ShowAllsComponent', () => {
  let component: ShowAllsComponent;
  let fixture: ComponentFixture<ShowAllsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowAllsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
