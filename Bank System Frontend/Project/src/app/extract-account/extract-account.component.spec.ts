import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExtractAccountComponent } from './extract-account.component';

describe('ExtractAccountComponent', () => {
  let component: ExtractAccountComponent;
  let fixture: ComponentFixture<ExtractAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExtractAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExtractAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
