import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVotesComponent } from './list-votes.component';

describe('ListVotesComponent', () => {
  let component: ListVotesComponent;
  let fixture: ComponentFixture<ListVotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListVotesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListVotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
